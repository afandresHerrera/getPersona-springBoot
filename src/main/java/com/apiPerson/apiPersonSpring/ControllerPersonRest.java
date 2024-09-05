    package com.apiPerson.apiPersonSpring;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class ControllerPersonRest {

        @GetMapping("/")
        public String person() {

            return "probando";
        }

    }
