<script setup>
import { defineProps } from 'vue';
import { ref, onMounted } from 'vue';

const { roomTitle } = defineProps({
    roomTitle: String,
});

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
});

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
                                <div class="card-body text-center">
                                    <div class="mb-2">
                                        <div class="text-center">
                                            <div>
                                                <i class="ki-duotone ki-time text-primary fs-4x mb-3">
                                                    <span class="path1"></span>
                                                    <span class="path2"></span>
                                                </i>
                                            </div>
                                            <div>
                                                <span class="fw-bold fs-1 fs-xl-1">{{ roomTitle }} 회의실</span>
                                                <span class="fs-1 fs-xl-1 text-gray">의 다음 회의는 </span>
                                                <span class="fw-bold fs-1 fs-xl-1 text-primary">어쩌구저쩌구관리미팅</span>
                                                <span class="fs-1 fs-xl-1 text-gray"> 입니다. </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="text-center">
                                        <span class="fs-2hx fs-xl-1 text-gray me-3">오전</span>
                                        <span class="fw-bold fs-4x fs-xl-1">11 : 30</span>
                                        <span class="fs-4x fs-xl-1 text-gray mx-4">~</span>
                                        <span class="fs-2hx fs-xl-1 text-gray me-3">오후</span>
                                        <span class="fw-bold fs-4x fs-xl-1">12 : 00</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="text-center mt-5">
                            <i class="ki-duotone ki-pin me-2 text-warning fs-4">
                                <span class="path1"></span>
                                <span class="path2"></span>
                            </i>
                            <span class="text-gray fs-4">원활한 회의실 사용을 위해 사용 후 뒷정리를 부탁드립니다</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
