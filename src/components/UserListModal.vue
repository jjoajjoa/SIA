<script setup>
import axios from 'axios';

import { ref, defineProps, defineEmits, onMounted } from 'vue';
import { Modal } from 'bootstrap';

const result = ref("");
const users = ref([]);

async function requestUserList() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://172.168.10.81:8001",
            url: "/user/list",
            responseType: "json",
        });
        result.value = `응답결과 -> ${JSON.stringify(response.data.data.data)}`;
        console.log(result.value)
        users.value = response.data.data.data;
    } catch (err) {
        result.value = `유저리스트에러 -> ${err}`;
    }
}

function modalCloseBtn() {
    const modal = new Modal(document.getElementById('userListModal'));
    modal.hide();
}

onMounted(() => {
    requestUserList();
});

</script>

<template>
    <div class="modal fade" id="userListModal" tabindex="-1" aria-labelledby="userListModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="userListModalLabel">예약자를 선택해주세요.</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <h1>Hello world!</h1>
                    </div>
                    <ul class="list-group">
                        <li v-for="user in users" :key="user.id" class="list-group-item list-group-item-action" @click="requestUserList()">
                            <span class="fw-bold">{{ user.name }}</span>
                            <span>{{ user.mobile }}</span>
                        </li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="modalCloseBtn()">닫기</button>
                </div>
            </div>
        </div>
    </div>
</template>