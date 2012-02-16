modules = {
    application {
        resource url:'js/application.js'
    }

    finn {
        resource url: 'css/custom.css'
        resource url: 'js/top.js', disposition: 'head'
        resource url: 'js/bottom.js'
    }
}