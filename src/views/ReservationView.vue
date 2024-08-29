<script setup>
import MainSidebarBody from '@/components/MainSidebarBody.vue';
import router from '@/router/index.js';
import axios from 'axios';
import { ref, defineProps, onMounted } from 'vue';
import { Modal } from 'bootstrap';

const selectedDate = ref(new Date().toISOString().substr(0, 10));
const startTime = ref('');
const isCurrentTimeChecked = ref(false);
const result = ref("");
const users = ref([]);
const selectedUserIds = ref([]);

const { roomTitle } = defineProps({
    roomTitle: String,
});

function goToMeeting() {
    const modalElem = document.querySelector('#reservationModal');
    const modal = new Modal(modalElem);
    modal.hide();
    router.replace({ path: '/meeting', query: {} });
}

function setStartTimeToCurrent() {
    if (isCurrentTimeChecked.value) {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        startTime.value = `${hours}:${minutes}`;
    }
}

async function requestUserList() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://localhost:8001",
            url: "/user/list",
            responseType: "json",
        });
        //result.value = `응답결과 -> ${JSON.stringify(response.data.data.data)}`;
        console.log(result.value)
        users.value = response.data.data.data;
    } catch (err) {
        result.value = `유저리스트에러 -> ${err}`;
    }
}

function getUserById(id) {
    return users.value.find(user => user.id === id) || {};
}

function removeUser(userId) {
    selectedUserIds.value = selectedUserIds.value.filter(id => id !== userId);
}

onMounted(() => {
    requestUserList();
});

</script>

<template>
    <div class="modal modal-xl fade" id="reservationModal" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <div class="modal-header">
                    <h2>{{ roomTitle }} 회의실 바로 예약</h2>
                    <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
                        <i class="ki-duotone ki-cross fs-1">
                            <span class="path1"></span>
                            <span class="path2"></span>
                        </i>
                    </div>
                </div>

                <div class="modal-body scroll-y mx-3 mx-xl-15 my-3">
                    <form id="kt_modal_new_card_form" class="form">
                        <div class="row">
                            <div class="col-7 ps-0 pe-7">

                                <div class="d-flex flex-row fv-row mb-5 align-items-center">
                                    <label class="fs-6 fw-semibold form-label mb-2 me-7">일자</label>
                                    <div class="position-relative flex-grow-1">
                                        <input type="date" class="form-control form-control-solid" v-model="selectedDate" />
                                    </div>
                                </div>

                                <div class="d-flex flex-row mb-7 fv-row align-items-center">
                                    <label class="fs-6 fw-semibold form-label mb-2 me-3">예약자</label>
                                    <div class="d-flex flex-row">
                                        <select name="user" class="form-select form-select-solid" v-model="selectedUserIds" multiple>
                                            <option v-for="user in users" :key="user.id" :value="user.id">
                                                <span>{{ user.name }}</span>
                                                <span> [{{ user.mobile }}]</span>
                                            </option>
                                        </select>
                                        <div class="d-flex align-items-center ms-5">
                                            <span v-for="userId in selectedUserIds" :key="userId" class="badge bg-primary text-light me-1">
                                                {{ getUserById(userId).name }}
                                                <button type="button" class="btn-close btn-close-white ms-2" @click="removeUser(userId)"></button>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                                <div class="d-flex align-items-center mb-10">
                                    <label class="fs-6 fw-semibold form-label mb-2 me-7">시간</label>
                                    <div class="d-flex align-items-center me-3">
                                        <input type="time" class="form-control form-control-solid me-2" v-model="startTime" />
                                        <span>~</span>
                                        <input type="time" class="form-control form-control-solid ms-2" />
                                    </div>
                                    <label class="d-flex align-items-center fs-6 fw-semibold form-label mb-2 ms-2">
                                        <input type="checkbox" class="me-2" v-model="isCurrentTimeChecked" @change="setStartTimeToCurrent" />
                                        <span>현재 시간부터 예약</span>
                                    </label>
                                </div>
                            </div>

                            <div class="col-5 card">
                                <MainSidebarBody :room-title="roomTitle" />
                            </div>

                            <div class="text-center pt-15">
                                <button type="reset" id="kt_modal_new_card_cancel" class="btn btn-light me-3">모두 지우기</button>
                                <button type="button" id="kt_modal_new_card_submit" class="btn btn-primary" data-bs-dismiss="modal" @click="goToMeeting()">
                                    <span class="indicator-label">예약</span>
                                    <span class="indicator-progress">Please wait...
                                        <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

