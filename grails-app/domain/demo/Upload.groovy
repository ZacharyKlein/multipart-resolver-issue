package demo

import org.springframework.web.multipart.MultipartFile

class Upload {

    MultipartFile file

    static transients = ['file']

    static constraints = {
    }
}
