<script setup>
import MainHeader from '@/components/MainHeader.vue';
import axios from 'axios';
import { ref, onMounted } from 'vue';
import { Modal } from 'bootstrap';

const titleInput = ref('');
const memoInput = ref('');
const selected = ref(-1);
const result = ref('');
const meetings = ref({
    room1: [],
    room2: [],
    room3: []
});

// 회의실1 요청
async function requestRoom1() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://localhost:8001",
            url: "/room/room1",
            responseType: "json",
        });
        meetings.value.room1 = response.data.data.data;
    } catch (err) {
        result.value = `회의실1 에러 -> ${err}`;
    }
}

// 회의실2 요청
async function requestRoom2() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://localhost:8001",
            url: "/room/room2",
            responseType: "json",
        });
        meetings.value.room2 = response.data.data.data;
    } catch (err) {
        result.value = `회의실2 에러 -> ${err}`;
    }
}

// 회의실3 요청
async function requestRoom3() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://localhost:8001",
            url: "/room/room3",
            responseType: "json",
        });
        meetings.value.room3 = response.data.data.data;
    } catch (err) {
        result.value = `회의실3 에러 -> ${err}`;
    }
}

//수정 요청
async function requestRoomUpdate(title, memo) {
    const data = {
        id: selected.value,
        title: title,
        memo: memo,
    };
    try {
        const response = await axios({
            method: "post",
            baseURL: "http://localhost:8001",
            url: "/room/update",
            data: data,
            responseType: "json",
        });
        const index = users.value.findIndex(user => user.id === selected.value);
        if (index !== -1) {
            users.value[index] = response.data;
        }
        await requestRoom1();
        await requestRoom2();
        await requestRoom3();
        selected.value = null;
    } catch (err) {
        result.value = `회의 수정 에러 -> ${err}`;
    }
}

//삭제 요청
function requestRoomDelete(room) {
    const data = {
        id: room.id,
    };
    axios({
        method: "post",
        baseURL: "http://localhost:8001",
        url: "/room/delete",
        data: data,
        responseType: "json",
    }).catch(function (err) {
        result.value = `유저삭제에러 -> ${err}`;
    }).then(function (response) {
        //result.value = `응답결과 -> ${JSON.stringify(response.data)}`;
        document.querySelector("#room-" + room.id).remove();
    })
}

//수정모달띄우기
function showRoomUpdateModal() {
    const modalElem = document.querySelector('#kt_modal_update_details');
    const modal = new Modal(modalElem);
    modal.show();
}

//수정 모드
function editRoom(roomId, roomNum) {
    console.log(`>>roomId: ${roomId}`);
    const room = meetings.value[roomNum].find(room => room.id === roomId);
    titleInput.value = room.title;
    memoInput.value = room.memo;
    selected.value = roomId;

    showRoomUpdateModal();
}

//수정 저장  
 function saveUser() {
    requestRoomUpdate(titleInput.value, memoInput.value);
    const modalElem = document.querySelector('#kt_modal_update_details');
    const modal = Modal.getInstance(modalElem);
    modal.hide();
}

onMounted(async () => {
    await requestRoom1();
    await requestRoom2();
    await requestRoom3();
});
</script>

<template>
    <MainHeader />
    <div class="app-wrapper flex-column flex-row-fluid" id="kt_app_wrapper" style="height: 100vh;">
        <div class="app-main flex-column flex-row-fluid" id="kt_app_main">
            <div class="d-flex flex-column flex-column-fluid">
                <div id="kt_app_content" class="app-content flex-column-fluid">
                    <div id="kt_app_content_container" class="app-container container-xxl">
                        <div>
                            <div class="card text-center fw-bold fs-2 py-5 mb-9">👀회의실 전체 현황 한눈에 보기👀</div>
                        </div>
                        <div class="d-flex row flex-xl-row">
                            <div class="col-4">
                                <div class="fs-1 fw-bold text-center">Earth 회의실</div>
                                <div class="w-xl-400px">
                                    <div class="card card-flush mt-5 p-3" v-for="meeting in meetings.room1" :key="meeting.id" :id="'schedule-' + meeting.id">
                                        <div class="d-flex row">
                                            <div class="d-flex col justify-content-between">
                                                <div class="text-gray fs-5">{{ meeting.formatted_date }} ({{meeting.start_time }} ~ {{ meeting.end_time }})</div>
                                                <div class="fs-4 fw-bold">{{ meeting.name }}</div>
                                            </div>
                                            <h3 class="text-primary">{{ meeting.title }}</h3>
                                            <div class="mt-4"><span class="fw-bold">메모: </span>{{ meeting.memo }}</div>
                                            <div class="d-flex d-flex justify-content-end">
                                                <div class="col-1 d-flex justify-content-end" @click="editRoom(meeting.id, 'room1')">
                                                    <i class="bi bi-pencil btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                                <div class="col-1 d-flex justify-content-end" @click="requestRoomDelete(meeting.id)">
                                                    <i class="bi bi-trash3 btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-4">
                                <div class="fs-2 fw-bold text-center">Hurble 회의실</div>
                                <div class="w-xl-400px">
                                    <div class="card card-flush mt-5 p-3" v-for="meeting in meetings.room2" :key="meeting.id">
                                        <div class="d-flex row">
                                            <div class="d-flex col justify-content-between">
                                                <div class="text-gray fs-5">{{ meeting.formatted_date }} ({{meeting.start_time }} ~ {{ meeting.end_time }})</div>
                                                <div class="fs-4 fw-bold">{{ meeting.name }}</div>
                                            </div>
                                            <h3 class="text-primary">{{ meeting.title }}</h3>
                                            <div class="mt-4"><span class="fw-bold">메모: </span>{{ meeting.memo }}</div>
                                            <div class="d-flex d-flex justify-content-end">
                                                <div class="col-1 d-flex justify-content-end" @click="editRoom(meeting.id, 'room2')">
                                                    <i class="bi bi-pencil btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                                <div class="col-1 d-flex justify-content-end">
                                                    <i class="bi bi-trash3 btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-4">
                                <div class="fs-2 fw-bold text-center">Jupiter 회의실</div>
                                <div class="w-xl-400px">
                                    <div class="card card-flush mt-5 p-3" v-for="meeting in meetings.room3" :key="meeting.id">
                                        <div class="d-flex row">
                                            <div class="d-flex col justify-content-between">
                                                <div class="text-gray fs-5">{{ meeting.formatted_date }} ({{meeting.start_time }} ~ {{ meeting.end_time }})</div>
                                                <div class="fs-4 fw-bold">{{ meeting.name }}</div>
                                            </div>
                                            <h3 class="text-primary">{{ meeting.title }}</h3>
                                            <div class="mt-4"><span class="fw-bold">메모: </span>{{ meeting.memo }}</div>
                                            <div class="d-flex d-flex justify-content-end">
                                                <div class="col-1 d-flex justify-content-end" @click="editRoom(meeting.id, 'room3')">
                                                    <i class="bi bi-pencil btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                                <div class="col-1 d-flex justify-content-end">
                                                    <i class="bi bi-trash3 btn btn-icon btn-active-light btn-active-color-primary w-20px h-30px"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="kt_modal_update_details" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered mw-650px">
            <div class="modal-content">
                <form class="form" action="#" id="kt_modal_update_user_form">
                    <div class="modal-header" id="kt_modal_update_user_header">
                        <h2 class="fw-bold">회의 내용 수정</h2>
                        <div class="btn btn-icon btn-sm btn-active-icon-primary" data-bs-dismiss="modal">
                            <i class="ki-duotone ki-cross fs-1">
                                <span class="path1"></span>
                                <span class="path2"></span>
                            </i>
                        </div>
                    </div>
                    <div class="modal-body py-10 px-lg-17">
                        <div id="kt_modal_update_user_user_info" class="collapse show">
                            <div class="fv-row mb-7">
                                <label class="fs-6 fw-semibold mb-2">회의 제목</label>
                                <input type="text" class="form-control form-control-solid"
                                    name="title" value="" v-model="titleInput" />
                            </div>
                            <div class="fv-row mb-7">
                                <label class="fs-6 fw-semibold mb-2">메모</label>
                                <input type="text" class="form-control form-control-solid"
                                    name="memo" value="" v-model="memoInput" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer flex-center">
                        <button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">모두
                            지우기</button>
                        <button type="button" class="btn btn-primary" @click="saveUser">
                            <span class="indicator-label">저장하기</span>
                            <span class="indicator-progress">Please wait...
                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>
