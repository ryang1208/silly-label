let express = require('express')
let router = express.Router()

const AVATAR = 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJbVzHjEel7s30taJDAU8M91FxicONoPv34iaK3ia7CxWHtRoMwMIUV8d0OaCOz0DcdrRMKtDAbTjbRw/132'

/**
 * 获取人员基本信息
 */
router.get(`/api/crm/userinfo`, (req, res) => {
  req.params = {
    riseId: 'riseId'
  }
  res.status(200).json({
    code: 200,
    msg: {
      riseId: 'riseid',
      avatar: AVATAR,
      nickName: '袁泉'
    }
  })
})

/**
 * 用户信息列表
 */
router.get(`/api/crm/student/userinfo/list`, (req, res) => {
  req.params = {
    nickName: '张三',
    riseId: 'fijweif',
    page: 1
  }
  res.status(200).json({
    code: 200,
    msg: {
      columnDefinition: [
        {
          title: '昵称',
          dataIndex: 'nickName',
        },
        {
          title: '年龄',
          dataIndex: 'age',
        },
        {
          title: '身份',
          dataIndex: 'identity',
        },
        {
          title: 'RiseId',
          dataIndex: 'riseId',
        },
        {
          title: '学习目的',
          dataIndex: 'bottleneck',
        },
      ],
      columnData: [
        {
          key: 1,
          riseId: 'fjeiwjp',
          nickName: '张三',
          age: '23-40',
          identity: '大学生',
          bottleneck: '跳槽', // 痛点
          paidList: [
            {
              key: 1,
              project: 'L1项目',
              paidTime: '2018-11-23 23:22:00',
              paidPrice: 30,
              promoter: '李四'
            }
          ],
          couponList: [
            {
              key: 1,
              description: '好友邀请',
              amount: 100
            }
          ]
        },
        {
          key: 2,
          riseId: 'fjeiwjp',
          nickName: '张三',
          age: '23-40',
          identity: '大学生',
          bottleneck: '跳槽', // 痛点
          paidList: [
            {
              project: 'L1项目',
              paidTime: '2018-11-23 23:22:00',
              paidPrice: 30,
              promoter: '李四'
            }
          ],
          couponList: [
            {
              description: '好友邀请',
              amount: 100
            }
          ]
        }
      ]
    }
  })
})

/**
 * 音频课数据
 */
router.get(`/api/crm/student/audioCourse`, (req, res) => {
  req.params = {
    riseId: 'riseid'
  }
  res.status(200).json({
    code: 200,
    msg: {
      historyList: [
        {
          key: 1,
          period: '2018-12-16 至 2018-12-23',
          teacher: '袁泉',
          day: '12-06',
          time: '12:30',
          markTime: '11:30'
        },
        {
          key: 2,
          period: '2018-12-16 至 2018-12-23',
          teacher: '袁泉',
          day: '12-07',
          time: '10:33',
          markTime: '11:30'
        },
        {
          key: 3,
          period: '2018-12-16 至 2018-12-23',
          teacher: '袁泉',
          day: '12-08',
          time: '11:30',
          markTime: '15:30'
        }
      ]
    }
  })
})

module.exports = router