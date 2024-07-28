package integration.bdd.stepdefnitions;

import com.ib.it.models.Book;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookControllerDefs extends BaseStepDefs {
    private final String API_GET_BOOK = "/api/v1/books/book?isbn={isbn}";

    @Given("I have a list of books")
    public void iHaveAListOfBooks() {
        System.out.println("I have a list of books. Nothing to do here.");
    }

    @When("I request book with isbn {string}")
    public void iRequestBookWithIsbn(String isbn) {
        var url = API_GET_BOOK.replace("{isbn}", isbn);
        response = webTestClient.get().uri(url).exchange();
    }

    @Then("I should receive book with isbn {string}")
    public void iShouldReceiveBookWithIsbn(String isbn) {
        response.expectStatus().isOk().
                expectBody(Book.class).consumeWith(response -> {
                    var book = response.getResponseBody();
                    assertTrue(book.getIsbn().equals(isbn));
                });
    }

    @Then("I should receive book not found")
    public void iShouldReceiveBookNotFound() {
        response.expectStatus().isNotFound();
    }
}
