import request from '@/utils/request'

/**
 * @description: 分页列表
 *
 * @return
 * @author weirx
 * @date 2020/6/30
 */
export function getPageList(data) {
    return request({
        url: '/bssp-generator-service/generate/pageList',
        method: 'post',
        data
    })
}

/**
 * Description: 生成代码
 *
 * Created date: 2020/7/14
 * @return
 * @author weirx
 */
export function generateCode(data) {
    return request({
        url: '/bssp-generator-service/generate/generateCode',
        method: 'post',
        responseType: 'blob',
        data
    })
}

/**
 * Description: 预览代码
 *
 * Created date: 2020/7/14
 * @return
 * @author weirx
 */
export function previewCode(data) {
    return request({
        url: '/bssp-generator-service/generate/previewCode',
        method: 'get',
        params: {tableName: data}
    })
}

/**
 * Description: 保存规则
 * Created date: 2020/7/20
 * @param null
 * @return
 * @author weirx
 */
export function saveRules(data) {
    return request({
        url: '/bssp-generator-service/generate/saveRules',
        method: 'post',
        data
    })
}


/**
 * Description: 根据id获取规则明细
 * Created date: 2020/7/20
 * @param null
 * @return
 * @author weirx
 */
export function getRules() {
    return request({
        url: '/bssp-generator-service/generate/getRules',
        method: 'get'
    })
}

