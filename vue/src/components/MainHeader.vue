<script setup>
import router from '@/router/index.js';

function goToHome() {
    router.replace({ path: '/', query: {} });
}
function goToMeetinRoomView() {
    router.replace({ path: '/meetingroom', query: {} });
}
</script>

<template>
    <div id="kt_app_header" class="app-header" data-kt-sticky="true" data-kt-sticky-activate="{default: true, lg: true}"
        data-kt-sticky-name="app-header-minimize" data-kt-sticky-offset="{default: '200px', lg: '0'}"
        data-kt-sticky-animation="false">
        <div class="app-container container-fluid d-flex align-items-stretch justify-content-between"
            id="kt_app_header_container">
            <div class="d-flex align-items-stretch justify-content-between flex-lg-grow-1" id="kt_app_header_wrapper">
                <div class="app-navbar flex-shrink-0">
                    <div class="app-navbar-item ms-1 ms-md-4">
                        <div class="btn btn-icon btn-custom btn-icon-muted btn-active-light btn-active-color-primary w-35px h-35px"
                            id="kt_activities_toggle" @click="goToHome()">
                            <i class="ki-duotone ki-home-1 fs-2hx">
                                <span class="path1"></span>
                                <span class="path2"></span>
                            </i>
                        </div>
                    </div>
                    <div class="app-navbar-item ms-1 ms-md-4">
                        <div class="btn btn-icon btn-custom btn-icon-muted btn-active-light btn-active-color-primary w-35px h-35px"
                            data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-attach="parent"
                            data-kt-menu-placement="bottom-end" id="kt_menu_item_wow" @click="goToMeetinRoomView()">
                            <i class="ki-duotone ki-people fs-2hx">
                                <span class="path1"></span>
                                <span class="path2"></span>
                                <span class="path3"></span>
                                <span class="path4"></span>
                                <span class="path5"></span>
                            </i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>