<script setup>
import MainSidebarBody from '@/components/MainSidebarBody.vue';
import router from '@/router/index.js';

import { defineProps } from 'vue';
import { Modal } from 'bootstrap';

const { roomTitle } = defineProps({
    roomTitle: String,
});

function goToMeeting() {
    const modalElem = document.querySelector('#reservationModal');
    const modal = new Modal(modalElem);
    modal.hide();
    router.replace({ path: '/meeting', query: {  } });
}
</script>

<template>
    <div class="modal modal-xl" id="reservationModal" tabindex="-1" aria-labelledby="reservationModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title fw-bold" id="reservationModalLabel">{{ roomTitle }} 회의실 바로 예약</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-7">
                                <div class="d-flex align-items-center mb-3">
                                    <label class="me-8 fw-bold">일 자</label>
                                    <input type="date" class="form-control me-2 text-bg-secondary">
                                </div>
                                <div class="d-flex align-items-center mb-3">
                                    <label class="me-5 fw-bold">예약자</label>
                                    <input type="text" class="form-control me-2 text-bg-secondary">
                                </div>
                                <div class="d-flex align-items-center mb-3">
                                    <label class="me-8 fw-bold">시 간</label>
                                    <input type="time" class="form-control me-2 text-bg-secondary"
                                        style="width: 200px;">
                                    <span class="mx-2 fw-bold">~</span>
                                    <input type="time" class="form-control me-3 text-bg-secondary"
                                        style="width: 200px;">
                                    <div class="form-check ms-auto">
                                        <input class="form-check-input" type="checkbox" id="currentTimeCheck">
                                        <label class="form-check-label" for="currentTimeCheck">
                                            현재시간부터 예약
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-5 card">
                                <MainSidebarBody :room-title="roomTitle" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">뒤로</button>
                    <button @click="goToMeeting()" type="button" class="btn btn-primary">
                        <i class="ki-duotone ki-time fs-2">
                            <span class="path1"></span>
                            <span class="path2"></span>
                        </i>예약
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>
