package main

import (
	"fmt"
	"io"
	"log"
	"net/http"

	"github.com/ruminder-hub/golang-http/handlers"
)

func welcome(writer http.ResponseWriter, request *http.Request) {
	io.WriteString(writer, "<h1>Welcome to first goLang application\n</h1>")
}
func hello(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprintf(writer, "Hello")
	fmt.Fprintf(writer, "<h1>First GoLang Application</h1>")
}
func main() {

	http.HandleFunc("/", welcome)
	http.HandleFunc("/hello", hello)
	http.HandleFunc("/api/", handlers.WelcomeAPI)
	http.HandleFunc("/api/hello", handlers.HelloAPI)
	log.Fatal(http.ListenAndServe(":3000", nil))
}
