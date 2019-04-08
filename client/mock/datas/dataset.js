let express = require('express')
let router = express.Router()

// 获取 自己所能看到的 所有数据集列表
router.get(`/api/dataset/list`, (req, res) => {
  req.params = {
    name: 'name' // 模糊匹配数据集名称
  }
  res.status(200).json({
    code: 200,
    msg: {
      count: 1,
      items: [
        {
          id: 1,
          userId: 1,
          name: 'name string',
          description: 'description string',
          uploadTime: '2019-04-07T09:43:03.912Z',
          uploadCount: '2019-04-07T09:43:03.912Z',
          taskRequirements: [
            {
              id: 1,
              userId: 1,
              datasetId: 1,
              categoryId: 1,
              label: {},
              reward: false,
              verifyStatus: false
            }
          ]
        }
      ]
    }
  })
})

// 创建数据集
router.post(`/api/dataset`, (req, res) => {
  req.params = {
    name: 'dataset string',
    description: 'description string',
    file: 'File'
  }
  req.status(200).json({
    code: 200,
    msg: 'msg string'
  })
})

module.exports = router
