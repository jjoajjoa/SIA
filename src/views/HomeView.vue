<script setup>
import MainHeader from '@/components/MainHeader.vue';
import MainContents from '@/components/MainContents.vue';
import MainSidebar from '@/components/MainSidebar.vue';
import ReservationView from './ReservationView.vue';

import { useRoomStore } from '@/stores/roomList';

const roomStore = useRoomStore();

function updateRoomTitle(newRoomTitle) {
    roomTitle.value = newRoomTitle;
}

</script>

<template>
    <!--<MainHeader />-->
    <div class="app-wrapper flex-column flex-row-fluid" id="kt_app_wrapper" style="height: 100vh;">
        <div class="app-main flex-column flex-row-fluid" id="kt_app_main">
            <div class="d-flex flex-column flex-column-fluid">
                <div id="kt_app_content" class="app-content flex-column-fluid">
                    <div id="kt_app_content_container" class="app-container container-xxl">
                        <div class="d-flex flex-column flex-xl-row">
                            <MainContents :room-title="roomStore.selectedRoom.name" />
                            <MainSidebar :room-list="roomStore.room" @updateRoomTitle="updateRoomTitle" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <ReservationView :room-title="roomStore.selectedRoom.name" />
</template>
