import request from '@/utils/request'
import axios from 'axios'
import qs from 'qs' // qs这个包在install  axios 时就已经装了，因为 qs 是 axios 的依赖包

/**
 * @description: 菜单tree
 *
 * @param null
 * @return
 * @author weirx
 * @date 2020/6/30
 */
export function getMenuTree(token) {
  return request({
    url: '/sysmenu/getTree',
    method: 'get',
    params: { token }
  })
}

/**
 * @description: 菜单分页列表
 *
 * @param null
 * @return
 * @author weirx
 * @date 2020/6/30
 */
export function getPageMenu(data) {
  return request({
    url: '/sysmenu/pageList',
    method: 'post',
    data
  })
}
