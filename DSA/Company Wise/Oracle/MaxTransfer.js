/** Use the HTTP GET method to retrieve information
from a database of patient medical records. Query
https://jsonmock.hackerrank.com/api/transactions
to find all the records. The query result is paginated
and can be further accessed by appending to the
query string ?page=num where num is the page
number.
The query response from the API is a JSON with the
following five fields:
page. the current page
per page the maxitnurn number of results per
page
torah the total number ot records in the search
the totat nutnber of pages to query to
get results
data. an array cf JSON Db)ects that
contain transaction recot(is
•
•
•
•
•
•
•
id: the unique ID of the transaction
userld: the id of the patient
userName: the name of the patient
timestamp
txnType: either 'credit' or 'debit'
amount: a float as a string in currency format. e.g.
•s 123,456.78'
location: object. the location of the user
o id:the unique ID of the location
o City
o zipCode
• 'p:lP address of the user
Gwen a user-Nanr and city, filter records by the
gjven keywords. Find the maxitnum amount
credited and the nnanmutn atnount debited for the
given user and the city. Return an array of strings
where the fust e:enlent is the credit atnount and
the seconci element the c't-•bit amount. These are
converted to *trines currency mat, just
as they are In the JSON data. */