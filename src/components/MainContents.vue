<script setup>
import { ref, defineProps, onMounted } from 'vue';
import { Modal } from 'bootstrap';

const { roomTitle } = defineProps({
    roomTitle: String,
});

const currentTime = ref('');
const nameInput = ref('');
const mobileInput = ref('');
const selected = ref(-1);
const result = ref('');
const users = ref([]);

function updateTime() {
    const now = new Date();
    const months = ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'];
    const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
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

function showUserList() {
    const modalElem = document.querySelector('#kt_modal_list_details');
    const modal = new Modal(modalElem);
    modal.show();
    requestUserList();
}

function showUserCreateModal() {
    const modalElem = document.querySelector('#kt_modal_update_details');
    const modal = new Modal(modalElem);
    modal.show();
}

//리스트 요청
async function requestUserList() {
    try {
        const response = await axios({
            method: "get",
            baseURL: "http://localhost:8001",
            url: "/user/list",
            responseType: "json",
        });
        //result.value = `응답결과 -> ${JSON.stringify(response.data.data.data)}`;
        console.log(result.value)
        users.value = response.data.data.data;
    } catch (err) {
        result.value = `유저리스트에러 -> ${err}`;
    }
}

//추가 요청
async function requestUserCreate(name, mobile) {
    const data = {
        name: name,
        mobile: mobile,
    };
    try {
        const response = await axios({
            method: "post",
            baseURL: "http://localhost:8001",
            url: "/user/create",
            data: data,
            responseType: "json",
        });
        //result.value = `응답결과 -> ${JSON.stringify(response.data)}`;
        users.value = response.data;
    } catch (err) {
        result.value = `유저추가에러 -> ${err}`;
    }
}

//수정 요청
async function requestUserUpdate(name, mobile) {
    const data = {
        id: selected.value,
        name: name,
        mobile: mobile,
    };
    try {
        const response = await axios({
            method: "post",
            baseURL: "http://localhost:8001",
            url: "/user/update",
            data: data,
            responseType: "json",
        });
        const index = users.value.findIndex(user => user.id === selected.value);
        if (index !== -1) {
            users.value[index] = response.data;
        }
        selected.value = null;
        requestUserList();
    } catch (err) {
        result.value = `유저수정에러 -> ${err}`;
    }
}

//삭제 요청
function requestUserDelete(user) {
    const data = {
        id: user.id,
    };
    axios({
        method: "post",
        baseURL: "http://localhost:8001",
        url: "/user/delete",
        data: data,
        responseType: "json",
    }).catch(function (err) {
        result.value = `유저삭제에러 -> ${err}`;
    }).then(function (response) {
        //result.value = `응답결과 -> ${JSON.stringify(response.data)}`;
        document.querySelector("#user-" + user.id).remove();
    })
}

//추가 저장
function saveUser() {
    requestUserCreate(nameInput.value, mobileInput.value);
    nameInput.value = '';
    mobileInput.value = '';
}

//수정 모드
function editUser(userId) {
    console.log(`>>userId: ${userId}`);
    const user = users.value.find(user => user.id === userId);
    nameInput.value = user.name;
    mobileInput.value = user.mobile;
    selected.value = userId;
}

//수정 저장
function saveEditedUser() {
    requestUserUpdate(nameInput.value, mobileInput.value);
    selected.value = null;
    requestUserList();
}

onMounted(() => {
    updateTime();
    setInterval(updateTime, 1000);
});

</script>

<template>
    <div class="d-flex flex-row-fluid me-xl-9 mb-10 mb-xl-0">
        <div class="card-flush card-p-0 bg-transparent border-0" style="width: 100%;">
            <div class="d-flex justify-content-end">
                <button class="btn btn-light-primary me-3" @click="showUserList">👀 사용자 보기</button>
                <button class="btn btn-light-primary" @click="showUserCreateModal">➕ 사용자 추가하기</button>
            </div>
            <!--상단 회의실 고르는 부분 시작-->
            <div class="card my-7">
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

    <!--사용자 모달-->
    <div class="modal fade" id="kt_modal_list_details" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered mw-650px">
            <div class="modal-content">
                <div class="modal-header" id="kt_modal_update_user_header">
                    <h2 class="fw-bold">사용자 목록</h2>
                    <div class="btn btn-icon btn-sm btn-active-icon-primary" data-bs-dismiss="modal">
                        <i class="ki-duotone ki-cross fs-1">
                            <span class="path1"></span>
                            <span class="path2"></span>
                        </i>
                    </div>
                </div>
                <div class="modal-body py-10 px-lg-17">
                    <ul>
                        <li v-for="user in users" :key="user.id" :id="'user-' + user.id">
                            <div v-if="selected === user.id">
                                <input v-model="nameInput" class="form-control" />
                                <input v-model="mobileInput" class="form-control" />
                                <span class="ms-2">
                                    <i class="bi bi-check-circle-fill" @click="saveEditedUser"></i>
                                </span>
                                <span class="ms-2">
                                    <i class="bi bi-x-circle-fill" @click="selected = null"></i>
                                </span>
                            </div>
                            <div v-else>
                                <span class="fw-bold fs-3">{{ user.name }}</span>
                                <span class="text-gray fs-3 ms-3">{{ user.mobile }}</span>
                                <button class="btn btn-white-blue btn-sm ms-5">
                                    <i class="bi bi-pencil" @click="editUser(user.id)"></i>
                                </button>
                                <button class="btn btn-white-blue btn-sm">
                                    <i class="bi bi-trash3" @click="requestUserDelete(user)"></i>
                                </button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <!--사용자 추가 모달-->
    <div class="modal fade" id="kt_modal_update_details" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered mw-650px">
            <div class="modal-content">
                <form class="form" action="#" id="kt_modal_update_user_form">
                    <div class="modal-header" id="kt_modal_update_user_header">
                        <h2 class="fw-bold">사용자 추가하기</h2>
                        <div class="btn btn-icon btn-sm btn-active-icon-primary" data-bs-dismiss="modal">
                            <i class="ki-duotone ki-cross fs-1">
                                <span class="path1"></span>
                                <span class="path2"></span>
                            </i>
                        </div>
                    </div>
                    <div class="modal-body py-10 px-lg-17">
                        <div id="kt_modal_update_user_user_info" class="collapse show">
                            <div class="fv-row mb-7">
                                <label class="fs-6 fw-semibold mb-2">이름</label>
                                <input type="text" class="form-control form-control-solid" placeholder="이름을 입력하세요."
                                    name="name" value="" v-model="nameInput" />
                            </div>
                            <div class="fv-row mb-7">
                                <label class="fs-6 fw-semibold mb-2">전화번호</label>
                                <input type="text" class="form-control form-control-solid" placeholder="전화번호를 입력하세요."
                                    name="mobile" value="" v-model="mobileInput" />
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer flex-center">
                        <button type="reset" class="btn btn-light me-3" data-kt-users-modal-action="cancel">모두 지우기</button>
                        <button type="button" class="btn btn-primary" @click="saveUser">
                            <span class="indicator-label">저장하기</span>
                            <span class="indicator-progress">Please wait...
                                <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</template>
