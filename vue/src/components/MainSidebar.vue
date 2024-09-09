<script setup>
import MainSidebarHeader from '@/components/MainSidebarHeader.vue';
import MainSidebarBody from '@/components/MainSidebarBody.vue';

import { defineEmits, defineProps } from 'vue';
import { useRoomStore } from '@/stores/roomList';

const emit = defineEmits(['updateRoomTitle']);
const roomStore = useRoomStore();

function selectRoom(roomName) {
    roomStore.setSelectedRoom(roomName);
    emit('updateRoomTitle', roomName);
}
</script>

<template>
    <div class="flex-row-auto w-xl-450px">
        <div class="card card-flush mt-5" id="kt_pos_form">
            <MainSidebarHeader />
            <MainSidebarBody :room-title="roomStore.selectedRoom.name" @updateRoomTitle="handleRoomTitleUpdate" />
            <div class="mx-4 mb-4">
                <button class="btn btn-primary fs-3 fw-bold w-100 py-4" data-bs-toggle="modal"
                    data-bs-target="#reservationModal">
                    <i class="ki-duotone ki-calendar-2 text-dark fs-1">
                        <span class="path1"></span>
                        <span class="path2"></span>
                        <span class="path3"></span>
                        <span class="path4"></span>
                        <span class="path5"></span>
                    </i>
                    <span>{{ roomStore.selectedRoom.name }} 회의실 바로 예약</span>
                </button>
            </div>
        </div>
    </div>
</template>
