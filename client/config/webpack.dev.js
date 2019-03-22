const webpack = require('webpack')
const merge = require('webpack-merge')
const common = require('./webpack.common')

module.exports = merge(common, {
  mode: 'development',
  devtool: 'inline-source-map',
  devServer: {
    hot: true,
    historyApiFallback: true,
    disableHostCheck: true,
    port: 8080,
    publicPath: '/',
    open: true,
    openPage: '',
    proxy: {
      '/api/*': {
        target: 'http://localhost:7001',
        secure: false,
        bypass: function (req, res, proxyOptions) {
          if (req.headers.accept && req.headers.accept.indexOf('html') !== -1) {
            console.log('Skipping proxy for browser request.')
            return '/index.html'
          } else {
            return false
          }
        }
      }
    }
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin()
  ]
})
