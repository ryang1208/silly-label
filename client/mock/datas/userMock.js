let express = require('express')
let router = express.Router()

router.post(`/api/label/user/login`, (req, res) => {
  req.params = {
    username: '',
    password: ''
  }
  res.status(200).json({
    code: 200,
    data: 'success'
  })
})

router.post(`/api/label/user/logout`, (req, res) => {
  req.params = {}
  res.status(200).json({
    code: 200,
    data: 'success'
  })
})

router.post(`/api/label/user/register`, (req, res) => {
  req.params = {
    username: '',
    password: ''
  }
  res.status(200).json({
    code: 200,
    data: 'success'
  })
})

router.post(`/api/label/user/reset`, (req, res) => {
  req.params = {
    username: '',
    oldPassword: '',
    newPassword: ''
  }
  res.status(200).json({
    code: 200,
    data: 'success'
  })
})

module.exports = router
