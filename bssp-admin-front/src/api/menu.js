import request from '@/utils/request'

/**
 * @description: 菜单tree
 *
 * @return
 * @author weirx
 * @date 2020/6/30
 */
export function getMenuTree(token) {
  return request({
    url: '/admin/sysmenu/getTree',
    method: 'get',
    params: { token }
  })
}

/**
 * @description: 菜单分页列表
 *
 * @return
 * @author weirx
 * @date 2020/6/30
 */
export function getPageMenu(data) {
  return request({
    url: '/admin/sysmenu/pageList',
    method: 'post',
    data
  })
}

/**
 * Description: 新增
 *
 * Created date: 2020/7/14
 * @return
 * @author weirx
 */
export function create(data) {
  return request({
    url: '/admin/sysmenu/save',
    method: 'post',
    data
  })
}

/**
 * Description: 更新
 *
 * Created date: 2020/7/14
 * @return
 * @author weirx
 */
export function update(data) {
  return request({
    url: '/admin/sysmenu/update',
    method: 'post',
    data
  })
}
