<script setup>
import router from '@/router/index.js';

import { defineProps } from 'vue';
import { ref, onMounted } from 'vue';
import { useRoomStore } from '@/stores/roomList';

const roomStore = useRoomStore();
const roomTitle = ref('');
const currentTime = ref('');

function updateTime() {
    const now = new Date();
    const months = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
    const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
    //const year = now.getFullYear();
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

onMounted(() => {
    updateTime();
    setInterval(updateTime, 1000);
    roomTitle.value = roomStore.selectedRoom.name;
});

function goToTimer() {
    router.replace({ path: '/timer', query: {  } });
}

</script>

<template>
    <div class="d-flex flex-row-fluid me-xl-9 mb-10 mb-xl-0">
        <div class="card-flush card-p-0 bg-transparent border-0" style="width: 100%;">
            <!--상단 회의실 고르는 부분 시작-->
            <div class="card my-12">
                <div class="d-flex justify-content-between py-5">
                    <div class="fw-bold text-gray-800 cursor-pointer text-hover-primary fs-2 fs-xl-1 ms-5">
                        <span>
                            <i class="ki-duotone ki-star fs-2 ms-3"></i>
                            {{ roomTitle }} 회의실
                        </span>
                    </div>
                    <div class="fw-bold text-gray-800 cursor-pointer text-hover-primary fs-2 fs-xl-1 me-5">
                        <div class="card-toolbar">
                            {{ currentTime }}
                        </div>
                    </div>
                </div>
            </div>
            <!--상단 회의실 고르는 부분 끝-->
            <div class="test card-body">
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="kt_pos_food_content_1">
                        <div class="d-flex flex-wrap d-grid gap-5 gap-xxl-9">
                            <div class="card card-flush flex-row-fluid p-6 pb-5 mw-100">
                                <div class="card-body">
                                    <div class="mb-2">
                                        <div class="mb-10">
                                            <p class="fw-bold fs-5 fs-xl-1 text-primary m-0">어쩌구저쩌구관리미팅</p>
                                            <p class="fw-bold fs-1 fs-xl-1"> 시간입니다. </p>
                                            <p>
                                                <i class="bi bi-stopwatch text-warning"></i>
                                                <span class="text-gray"> 회의 시작하기 버튼을 눌러 회의를 시작해주세요!</span>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="text-center">
                                        <div class="card bk-gray py-5">
                                            <p class="fw-bold fs-3 fs-xl-3 text-primary m-0">어쩌구저쩌구관리미팅</p>
                                            <p class="fw-bold fs-3 fs-xl-3"> 회의실 예약 시간 </p>
                                            <div class="text-center">
                                                <span class="fw-bold fs-1 fs-xl-1 text-gray me-3">오전</span>
                                                <span class="fw-bold fs-2hx fs-xl-1">11 : 30</span>
                                                <span class="fs-2x fs-xl-1 text-gray mx-4">~</span>
                                                <span class="fw-bold fs-1 fs-xl-1 text-gray me-3">오후</span>
                                                <span class="fw-bold fs-2hx fs-xl-1">12 : 00</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center mt-5">
                                    <p class="text-gray fs-5 mb-5">10분 내에 시작되지 않으면 예약이 노쇼 처리됩니다.</p>
                                    <button @click="goToTimer()" class="btn btn-primary fs-3 w-100 py-4">회의 시작하기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
