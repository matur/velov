Main objective:

Find a path from BEGIN to END within points provided.

How it works:
* Run server with "java -jar target/velov-1.0-SNAPSHOT.jar" command
* Call api with 2 parameter and one post-body
    * Parameters:
        * start => Contains the ID of the departure point
        * end => Contains the ID of the arrival point
    * Body
        * It is an JSON array of points.
```
    {
      "id": 10027,                        # => Unique Identifier of the point
      "name": "Mairie de Villeurbanne",   # => Name of the point
      "latitude": 45.766830606452515,     # => Latitude of the point
      "longitude": 4.87989386727746,      # => Longitude of the point
      "links": [                          # => List of links FROM this point TO another point (identified by ID)
        {"id": 10034, "distance": 85},
        {"id": 10047, "distance": 81},
        {"id": 10048, "distance": 65},
        {"id": 10079, "distance": 98}
      ]
    }
```

Example of call:
    WARNING: It's necessary to add this header "Content-Type: application/json"

```
curl -H "Content-Type: application/json" -X POST -d "@map1.json" "http://your-server.com:8080/solve.json?end=10030&begin=10121" | python -m json.tool

```