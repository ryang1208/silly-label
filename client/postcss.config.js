module.exports = {
  plugins: [
    require('autoprefixer')({
      browsers: ['last 5 versions', 'iOS > 7', 'Android > 4.2']
    })
  ],
  remove: false
}
