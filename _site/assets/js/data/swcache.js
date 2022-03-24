const resource = [

  /* --- CSS --- */
  '/CSA-Data-Structures/assets/css/style.css',

  /* --- PWA --- */
  '/CSA-Data-Structures/app.js',
  '/CSA-Data-Structures/sw.js',

  /* --- HTML --- */
  '/CSA-Data-Structures/index.html',
  '/CSA-Data-Structures/404.html',
  
    '/CSA-Data-Structures/code/',
  
    '/CSA-Data-Structures/notes/',
  
    '/CSA-Data-Structures/ticket/',
  

  /* --- Favicons & compressed JS --- */
  
  
    '/CSA-Data-Structures/assets/img/favicons/android-chrome-192x192.png',
    '/CSA-Data-Structures/assets/img/favicons/android-chrome-512x512.png',
    '/CSA-Data-Structures/assets/img/favicons/apple-touch-icon.png',
    '/CSA-Data-Structures/assets/img/favicons/favicon-16x16.png',
    '/CSA-Data-Structures/assets/img/favicons/favicon-32x32.png',
    '/CSA-Data-Structures/assets/img/favicons/favicon.ico',
    '/CSA-Data-Structures/assets/img/favicons/mstile-150x150.png',
    '/CSA-Data-Structures/assets/js/dist/categories.min.js',
    '/CSA-Data-Structures/assets/js/dist/commons.min.js',
    '/CSA-Data-Structures/assets/js/dist/home.min.js',
    '/CSA-Data-Structures/assets/js/dist/misc.min.js',
    '/CSA-Data-Structures/assets/js/dist/page.min.js',
    '/CSA-Data-Structures/assets/js/dist/post.min.js',
    '/CSA-Data-Structures/assets/js/dist/pvreport.min.js'

];

/* The request url with below domain will be cached */
const allowedDomains = [
  

  'localhost:4000',

  

  'fonts.gstatic.com',
  'fonts.googleapis.com',
  'cdn.jsdelivr.net',
  'polyfill.io'
];

/* Requests that include the following path will be banned */
const denyUrls = [
  
];
