<script setup>
import MeetingTimerYes from '../components/MeetingTimerYes.vue';
import MeetingTimerNo from '../components/MeetingTimerNo.vue';

import { ref, onMounted } from 'vue';
import { useRoomStore } from '@/stores/roomList';
import { Modal } from 'bootstrap';

const currentTime = ref('');
const showTimer = ref(true);

function updateTime() {
    const now = new Date();
    const months = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
    const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
    const month = months[now.getMonth()];
    const day = now.getDate();
    const dayOfWeek = daysOfWeek[now.getDay()];
    let hours = now.getHours();
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const period = hours >= 12 ? '오후' : '오전';
    hours = hours % 12 || 12;
    hours = String(hours).padStart(2, '0');
    currentTime.value = `${month} ${day}일 (${dayOfWeek}) ${period} ${hours}:${minutes}`;
}

function showModalMeetingEnd() {
    const modalEndElem = document.querySelector('#kt_modal_1')
    const modalEnd = new Modal(modalEndElem);
    modalEnd.show();
}

onMounted(() => {
    updateTime();
    setInterval(updateTime, 1000);
});

</script>

<template>
    <div class="d-flex flex-row-fluid me-xl-9 mb-10 mb-xl-0">
        <div class="card-flush card-p-0 bg-transparent border-0 ms-10" style="width: 100%;">

            <div class="card mt-12 mb-6">
                <div class="d-flex justify-content-between py-5">
                    <div class="fw-bold cursor-pointer ms-10">
                        <span class="fs-4 me-2 text-gray">오전</span>
                        <span class="fs-1">11:30</span>
                        <span class="fs-4 text-gray mx-3">~</span>
                        <span class="fs-4 me-2 text-gray">오후</span>
                        <span class="fs-1">12:00</span>
                    </div>
                    <div class="fw-bold text-gray-800 cursor-pointer text-hover-primary fs-2 fs-xl-1 me-5">
                        <div class="card-toolbar">
                            {{ currentTime }}
                            <i class="ki-duotone ki-burger-menu-6 fs-2 ms-3 text-dark"></i>
                        </div>
                    </div>
                </div>
                <div class="d-flex justify-content-between py-5">
                    <div class="fw-bold cursor-pointer ms-10">
                        <span class="fs-4 fs-xl-4 me-2 text-gray">회의 제목</span>
                        <span class="fs-1 fs-xl-1">어쩌구저쩌구관리미팅</span>
                    </div>
                    <div class="fw-bold fs-2 fs-xl-1 me-5">
                        <div class="card-toolbar">
                            <span class="badge badge-light-primary border-4 fs-3 me-3 px-3 py-2">정지유</span>
                            <span class="badge badge-light-primary border-4 fs-3 me-3 px-3 py-2">스탑유</span>
                            <span class="badge badge-light-primary border-4 fs-3 me-3 px-3 py-2">전진유</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="d-flex mb-3">
                <div class="p-2 ">
                    <button class="card btn-bg-white py-3 px-5 fs-4 fw-bold">예약 현황</button>
                </div>
                <div class="p-2">
                    <button class="card btn-bg-white py-3 px-5 fs-4 fw-bold">바로 예약</button>
                </div>
                <div class="ms-auto p-2">
                    <p class="card btn-bg-white py-3 px-5 fs-6">
                        <span class="form-check form-check-solid form-switch form-check-custom fv-row">
                            <label class="form-check-label me-3" for="allowmarketing">타이머 보기</label>
                            <input class="form-check-input w-30px h-15px" type="checkbox" id="allowmarketing"
                                v-model="showTimer" />
                        </span>
                    </p>
                </div>
            </div>

            <MeetingTimerYes v-if="showTimer" />
            <MeetingTimerNo v-else />

            <div>
                <div class="d-flex justify-content-between mt-10">
                    <span>
                        <i class="bi bi-info-circle-fill fs-4 me-2"></i>
                        <span class="fw-bold fs-5 text-gray-700">회의 연장 요청은 회의 종료 5분 전까지만 가능합니다.</span>
                    </span>
                    <button class="btn btn-primary px-19" @click="showModalMeetingEnd()">
                        <i class="bi bi-power fs-3"></i>회의 종료
                    </button>
                </div>
            </div>

        </div>

        <!--회의종료모달 시작-->
        <div class="modal fade" tabindex="-1" id="kt_modal_1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <h3 class="modal-title text-center my-10">
                            <p><i class="bi bi-exclamation-triangle fs-2hx"></i></p>
                            회의를 <span class="fw-bold">정말 종료하시겠습니까?</span>
                        </h3>
                    </div>
                    <div class="d-flex justify-content-center my-5">
                        <button type="button" class="btn btn-light me-3" data-bs-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary">종료</button>
                    </div>
                </div>
            </div>
        </div>
        <!--회의종료모달 끝-->

        <!--회의시간연장모달 시작-->
        <div>
            <div class="modal fade" tabindex="-1" id="kt_modal_1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <h3 class="modal-title text-center my-10">
                                회의 예약 시간 연장하기
                            </h3>
                        </div>
                        <div>
                            
                        </div>
                        <div class="d-flex justify-content-center my-5">
                            <button type="button" class="btn btn-light me-3" data-bs-dismiss="modal">취소</button>
                            <button type="button" class="btn btn-primary">연장</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--회의시간연장모달 끝-->
    </div>
</template>
