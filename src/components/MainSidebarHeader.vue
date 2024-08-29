<script setup>
import router from '@/router/index.js';
import { useRoomStore } from '@/stores/roomList';

const roomStore = useRoomStore();

function selectRoom(roomName) {
    roomStore.setSelectedRoom(roomName);
}

function goToMeetinRoomView() {
    router.replace({ path: '/meetingroom', query: {} });
}
</script>

<template>
    <div class="overflow-auto pb-5">
        <div class="card-header py-3" style="background-color: #eee;">
            <div class="card-toolbar row d-flex justify-content-center">
                <div class="row">
                    <button class="btn btn-white-blue fw-bold mb-3" @click="goToMeetinRoomView()">전체 회의실 현황 한번에 보기 👀</button>
                </div>
                <button v-for="room in roomStore.room" :key="room.id" class="btn btn-white-blue fw-bold py-3 me-2 col"
                    @click="selectRoom(room.name)">
                    <i class="ki-duotone ki-delivery-door">
                        <span class="path1"></span>
                        <span class="path2"></span>
                        <span class="path3"></span>
                        <span class="path4"></span>
                    </i>
                    {{ room.name }} 회의실
                </button>
            </div>
        </div>
    </div>
</template>
