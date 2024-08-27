import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useRoomStore = defineStore('room', () => {
    const room = ref([
        {
            id: 0,
            name: 'Earth'
        },
        {
            id: 1,
            name: 'Hurble'
        },
        {
            id: 1,
            name: 'Jupiter'
        }
    ])

    const selectedRoom = ref(room.value[0]);

    function setSelectedRoom(roomName) {
        const roomItem = room.value.find(r => r.name === roomName);
        if (roomItem) {
            selectedRoom.value = roomItem;
        }
    }

    return { room, selectedRoom, setSelectedRoom };
})
