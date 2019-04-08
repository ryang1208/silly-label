let express = require('express')
let router = express.Router()

// 获取标记数据列表
router.get(`/api/label/mark/list`, (req, res) => {
  req.params = {
    taskRequirementId: 1,
    mimeType: 'image',
    idx: 0
  }
  res.status(200).json({
    code: 200,
    msg: [
      {
        id: 1,
        userId: 1,
        datasetId: 1,
        imageId: 1,
        imageTaskRequirementId: 1,
        imageUrl: 'imageUrl string',
        labelContent: 'labelContent string'
      }
    ]
  })
})

// 创建/更新 标记数据
router.post(`/api/label/mark`, (req, res) => {
  req.params = {
    taskRequirementId: 0,
    mimeType: 'image',
    labelContent: {}
  }
  res.status(200).json({
    code: 200,
    msg: ''
  })
})

module.exports = router
