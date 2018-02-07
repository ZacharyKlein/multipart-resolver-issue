package demo

import groovy.util.logging.Slf4j
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.multipart.MultipartException
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest
import org.springframework.web.multipart.support.StandardServletMultipartResolver

import javax.servlet.http.HttpServletRequest

@Slf4j
class NcJJMultipartResolver extends StandardServletMultipartResolver {

    static final String FILE_SIZE_EXCEEDED_ERROR = "fileSizeExceeded"

    @Override
    MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
        try {
            return super.resolveMultipart(request)
        } catch (Exception e) {//MaxUploadSizeExceededException
            log.warn("${e} - ${e.message}")

            //new StandardMultipartHttpServletRequest(request)
            new DefaultMultipartHttpServletRequest(request, new LinkedMultiValueMap<String, MultipartFile>(), new LinkedHashMap<String, String[]>(), new LinkedHashMap<String, String>())
        }


    }
}