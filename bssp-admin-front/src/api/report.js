import request from '@/utils/request'

export function report() {
    return request({
        url: '/generate/report',
        method: 'post',
        responseType: 'blob'
    })
}

export function exportPdf(data) {
    return request({
        url: '/generate/exportPdf',
        method: 'post',
        responseType: 'blob',
        data
    })
}

export function exportHtml(data) {
    return request({
        url: '/generate/exportHtml',
        method: 'post',
        responseType: 'blob',
        data
    })
}
