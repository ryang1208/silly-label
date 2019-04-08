let express = require('express')
let router = express.Router()

// 获取图片详情
router.get(`/api/image/detail`, (req, res) => {
  req.params = {
    idx: 0 // 图片在数据集中的索引位置
  }
  res.status(200).json({
    code: 200,
    msg: {
      id: 1,
      url: 'url string'
    }
  })
})

module.exports = router
