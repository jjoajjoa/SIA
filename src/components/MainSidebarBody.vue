<script setup>
import { defineEmits, defineProps } from 'vue';

const emit = defineEmits(['updateRoomTitle']);
const { roomTitle } = defineProps({
    roomTitle: String,
});

</script>

<template>
    <div class="mt-2">
                <div class="bk-gray fs-3 fw-bold ps-5 py-2">
                    <i class="ki-duotone ki-delivery-door text-dark fs-3 me-2">
                        <span class="path1"></span>
                        <span class="path2"></span>
                        <span class="path3"></span>
                        <span class="path4"></span>
                    </i>
                    <span>{{ roomTitle }} 회의실 예약 현황</span>
                </div>
            </div>
            <div class="card-body pt-0">
                <div class="my-5">
                    <div class="timeline">
                        <div class="time-slot">
                            <div class="time-label">오전 11:00</div>
                            <div class="time-line">
                                ───────────────────────
                            </div>
                        </div>
                        <div class="time-slot">
                            <div class="time-label">오전 11:30</div>
                            <div class="time-line">
                                ───────────────────────
                            </div>
                        </div>
                        <div class="time-slot">
                            <div class="time-label">오후 12:00</div>
                            <div class="time-line">
                                ───────────────────────
                            </div>
                        </div>
                        <div class="time-slot">
                            <div class="time-label">오후 12:30</div>
                            <div class="time-line">
                                ───────────────────────
                            </div>
                            <div class="notice-event bg-light-info rounded border-info border border-dashed px-6 py-2">
                                <p class="event-title">개발 1팀 프로젝트 진행 현황 점검</p>
                                <p class="event-participants">백남주, 이석도, 안선정</p>
                                <p class="text-info">오후 12:30 - 오후 01:00</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</template>