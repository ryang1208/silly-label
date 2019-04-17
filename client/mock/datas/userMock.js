let express = require('express')
let router = express.Router()

router.post(`/api/label/user/login`, (req, res) => {
  req.params = {
    datasetId: 1, // 数据集 id（可选）
    mimeType: 'image' // 媒体类型（可选）
  }
  res.status(200).json({
    code: 200,
    msg: {
      image: [
        {
          id: 1,
          userId: 1,
          datasetId: 1,
          categoryId: 1,
          label: {},
          reward: false,
          verifyStatus: false
        }
      ],
      video: [
        {
          id: 2,
          userId: 1,
          datasetId: 2,
          categoryId: 2,
          label: {},
          reward: false,
          verifyStatus: false
        }
      ]
    }
  })
})

router.post(`/api/label/user/logout`, (req, res) => {
  req.params = {
    id: 1, // 任务 id
    mimeType: 'image' // 媒体类型
  }
  res.status(200).json({
    code: 200,
    msg: {
      id: 0,
      userId: 0,
      datasetId: 0,
      categoryId: 0,
      label: {},
      reward: false,
      verifyStatus: false,
      category: {
        id: 0,
        categoryName: 'categoryName string'
      },
      datasets: [
        {
          id: 0,
          userId: 0,
          name: 'name string',
          description: 'description string',
          uploadTime: '2019-04-07T09:57:55.044Z',
          uploadCount: '2019-04-07T09:57:55.044Z'
        }
      ]
    }
  })
})

router.post(`/api/label/user/register`, (req, res) => {
  req.params = {
    datasetId: 1,
    categoryId: 1,
    mimeType: 'image',
    label: {},
    reward: 0
  }
  res.status(200).json({
    code: 200,
    msg: ''
  })
})

router.post(`/api/label/user/reset`, (req, res) => {
  req.params = {
    datasetId: 1,
    categoryId: 1,
    mimeType: 'image',
    label: {},
    reward: 0
  }
  res.status(200).json({
    code: 200,
    msg: ''
  })
})

module.exports = router
