import request from '@/utils/request'

export function report() {
    return request({
        url: '/bssp-generator-service/generate/report',
        method: 'post',
        responseType: 'blob'
    })
}

export function exportPdf(data) {
    return request({
        url: '/bssp-generator-service/generate/exportPdf',
        method: 'post',
        responseType: 'blob',
        data
    })
}

export function exportHtml(data) {
    return request({
        url: '/bssp-generator-service/generate/exportHtml',
        method: 'post',
        responseType: 'blob',
        data
    })
}
