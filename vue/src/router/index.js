import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/reservation',
            name: 'reservation',
            component: () => import('../views/ReservationView.vue')
        },
        {
            path: '/meeting',
            name: 'meeting',
            component: () => import('../views/MeetingView.vue')
        },
        {
            path: '/meetingroom',
            name: 'meetingroom',
            component: () => import('../views/MeetingRoomView.vue')
        },
        {
            path: '/timer',
            name: 'timer',
            component: () => import('../views/MeetingTimer.vue')
        },
        {
            path: '/about',
            name: 'about',
            component: () => import('../views/AboutView.vue')
        }
    ]
})

export default router
