module.exports = {
  plugins: [
    require('precss'),
    require('autoprefixer'),
    require('postcss-simple-vars')({
      variables: {
        desktop: 'screen and (min-width: 769px)',
        info: '#40cec0',
        accent: 'hsl(152, 84%, 60%)',
        normal: '12px',
        large: '14px',
        xlarge: '17px',
      },
    }),
  ],
}
