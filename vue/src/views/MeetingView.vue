<script setup>
import MainHeader from '@/components/MainHeader.vue';
import MeetingStart from '../components/MeetingStart.vue';
import MainSidebarBody from '@/components/MainSidebarBody.vue';

import { defineProps } from 'vue';

const { roomTitle } = defineProps({
    roomTitle: String,
});

</script>

<template>
    <MainHeader />
    <div class="app-wrapper flex-column flex-row-fluid" id="kt_app_wrapper" style="height: 100vh;">
        <div class="app-main flex-column flex-row-fluid" id="kt_app_main">
            <div class="d-flex flex-column flex-column-fluid">
                <div id="kt_app_content" class="app-content flex-column-fluid">
                    <div id="kt_app_content_container" class="app-container container-xxl">
                        <div class="d-flex flex-column flex-xl-row">
                            <MeetingStart :room-title="roomTitle" />
                            <div class="flex-row-auto w-xl-450px">
                                <div class="card card-flush mt-5" id="kt_pos_form">
                                    <MainSidebarBody :room-title="roomTitle" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
