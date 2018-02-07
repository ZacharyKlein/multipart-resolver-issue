package maxfileupload

import demo.CustomMultipartResolver
import demo.Upload
import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class UploadController {

    def index() {

        [uploadInstance: new Upload()]
    }


    def save(UploadCmd uploadCmd) {
        //println params
        println uploadCmd.file

        if (request.getAttribute(CustomMultipartResolver.FILE_SIZE_EXCEEDED_ERROR)) {
            println "File size exceeded!"
            flash.message = "File size exceeded!"

            Upload uploadInstance = new Upload()
            respond uploadInstance, [view: "index", model: [uploadInstance: uploadInstance, params: params]]
        } else {
            println "File ${uploadCmd.file?.originalFilename} uploaded!"
            flash.message = "File ${uploadCmd.file?.originalFilename} uploaded!"

            redirect action: "index"
        }
    }
}


class UploadCmd implements Validateable {
    MultipartFile file
}
