<script setup>
import { useRoomStore } from '@/stores/roomList';

const roomStore = useRoomStore();

function selectRoom(roomName) {
    roomStore.setSelectedRoom(roomName);
}
</script>

<template>
    <div class="card-header py-3" style="background-color: #eee;">
        <div class="card-toolbar">
            <button v-for="room in roomStore.room" :key="room.id" class="btn btn-white-blue fw-bold py-3 me-2 mb-3"
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
</template>
