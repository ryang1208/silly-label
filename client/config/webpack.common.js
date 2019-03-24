const path = require('path')
const process = require('process')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const CleanWebpackPlugin = require('clean-webpack-plugin')
const TsconfigPathsPlugin = require('tsconfig-paths-webpack-plugin')
const ForkTsCheckerWebpackPlugin = require('fork-ts-checker-webpack-plugin')

const themeConfig = require('../theme.config')

const isDev = process.env.npm_lifecycle_event !== 'prod'

module.exports = {
  entry: {
    app: ['./src/index.tsx']
  },
  output: {
    path: path.resolve(__dirname, '../dist'),
    filename: '[name].bundle_[hash].js',
    chunkFilename: '[id].chunk_[chunkhash].js',
    publicPath: '/'
  },
  resolve: {
    extensions: ['.js', '.jsx', '.ts', '.tsx'],
    plugins: [
      new TsconfigPathsPlugin({
        configFile: path.join(__dirname, '../', 'tsconfig.json')
      })
    ]
  },
  module: {
    rules: [
      {
        test: /\.(jsx?|tsx?)$/,
        exclude: /node_modules/,
        use: [
          'babel-loader',
          {
            loader: 'ts-loader',
            options: {
              transpileOnly: isDev
            }
          }
        ]
      },
      {
        test: /\.less$/,
        // exclude: /node_modules/,
        use: [
          'style-loader',
          'css-loader',
          'postcss-loader',
          {
            loader: 'less-loader',
            options: {
              modifyVars: themeConfig,
              javascriptEnabled: true
            }
          }
        ]
      },
      {
        test: /\.css$/,
        // exclude: /node_modules/,
        use: ['style-loader', 'css-loader', 'postcss-loader']
      },
      {
        test: /\.(gif|jpg|png)$/,
        exclude: /node_modules/,
        use: ['url-loader']
      },
      {
        test: /\.(woff|woff2|eot|ttf|svg)$/,
        exclude: /node_modules/,
        use: ['file-loader']
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: 'index.html',
      inject: true
    }),
    new CleanWebpackPlugin()
  ]
}
