<script setup>
import { ref, computed } from 'vue';

const timerSize = 150;
const totalTime = 30 * 60; //30m
const remainingTime = ref(totalTime);
const formattedTime = computed(() => {
    const minutes = Math.floor(remainingTime.value / 60);
    const seconds = remainingTime.value % 60;
    return `${String(minutes).padStart(2, '0')} : ${String(seconds).padStart(2, '0')}`;
});
const circleLength = 2 * Math.PI * timerSize;
const circleStyle = computed(() => {
    const dashoffset = circleLength * (1 - remainingTime.value / totalTime);
    return {
        strokeDasharray: circleLength,
        strokeDashoffset: dashoffset,
    };
});
setInterval(() => {
    if (remainingTime.value > 0) {
        remainingTime.value--;
    }
}, 1000);
</script>

<template>
    <div class="text-center">
        <div class="timer">
            <div class="svg-container">
                <svg>
                    <circle class="background-circle" cx="50%" cy="50%" r="150"></circle>
                    <circle class="foreground-circle" :style="circleStyle" cx="50%" cy="50%" r="150"></circle>
                </svg>
                <div class="timer-text fs-3hx fw-bold">
                    <span id="time">{{ formattedTime }}</span>
                    <div class="">
                        <button class="btn btn-primary fs-3 px-7 py-3">+ 연장하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>