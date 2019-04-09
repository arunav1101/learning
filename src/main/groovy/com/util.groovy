package com

import groovyx.net.http.RESTClient


import static groovyx.net.http.ContentType.JSON

import static groovyx.net.http.Method.GET


class util extends ServiceUtil{
    def myUrl = new RESTClient("https://swapi.co/api/planets/")

    def search(boolean assertions) {
        def serviceCall = {
            myUrl.request(GET, JSON){
            }
        }
        def response = serviceHelper(assertions, serviceCall, 200)
        return response
    }


    def searchById(boolean assertions, String myUri) {
        def serviceCall = {
            myUrl.request(GET, JSON){
                uri.path = myUri
            }
        }
        def response = serviceHelper(assertions, serviceCall, 200)
        return response
    }

}