import request from '@/utils/request'

export function getMenuTree() {
  return request({
    url: '/sysmenu/getTree',
    method: 'get',
  })
}
