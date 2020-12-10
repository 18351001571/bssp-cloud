import request from '@/utils/request'

export function report() {
    return request({
        url: '/bssp-generate-service/report',
        method: 'post',
        responseType: 'blob'
    })
}

export function exportPdf(data) {
    return request({
        url: '/bssp-generate-service/exportPdf',
        method: 'post',
        responseType: 'blob',
        data
    })
}

export function exportHtml(data) {
    return request({
        url: '/bssp-generate-service/exportHtml',
        method: 'post',
        responseType: 'blob',
        data
    })
}
