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
    url: '/generate-api/generate/pageList',
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
    url: '/generate-api/generate/generateCode',
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
    url: '/generate-api/generate/previewCode',
    method: 'post',
    data
  })
}

