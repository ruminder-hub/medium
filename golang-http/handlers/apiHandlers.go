package handlers

import (
	"fmt"
	"io"
	"net/http"
)

func WelcomeAPI(writer http.ResponseWriter, request *http.Request) {
	io.WriteString(writer, "<h1>Welcome to first goLang application\n</h1>")
}
func HelloAPI(writer http.ResponseWriter, request *http.Request) {
	fmt.Fprintf(writer, "Hello")
	fmt.Fprintf(writer, "<h1>First GoLang Application</h1>")
}
