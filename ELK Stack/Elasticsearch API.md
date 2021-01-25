## 비정상 상황

#### Replica Unassigned shard

```json
POST _cluster/reroute?retry_failed=true
{
   "commands": [
      {
         "allocate_replica": {
            "index": "ciscofw-2020081207",            
            "shard": "17",
            "node": "data-3-2"
         }
      }
   ]
}
```

> `?retry_failed=true` 를 붙이지 않을땐 ERROR, 붙이니 작동함



## Rolling Restarts

> - http://asuraiv.blogspot.com/2015/04/elasticsearch-rolling-restarts.html
> - https://www.elastic.co/guide/en/elasticsearch/reference/current/restart-cluster.html



```
POST /_cluster/reroute?retry_failed=true
{
  "commands": [
    {
      "allocate_replica": {
        "index": "ciscofw-2020082115", 
        "shard": 5,
        "node": "data-3-1"
      }
    }
  ]
}
POST /_cluster/reroute?retry_failed=true
{
  "commands": [
    {
      "move": {
        "index": "ciscofw-2020082115", "shard": 5,
        "from_node": "data-2-1", "to_node": "data-3-1"
      }
    }
  ]
}

GET /_cluster/settings?include_defaults&flat_settings&local&filter_path=defaults.indices*

GET /_nodes/hot_threads
GET /_nodes/data-3-2/hot_threads
GET /_nodes/stats
GET /_cluster/stats?human&pretty
GET /_nodes/process
GET /_cluster/health

# 업데이트 전에 allocation 불가하게 none 설정 후 업그레이드 후 다시 all로 변경
PUT _cluster/settings
{
  "transient": {
    "cluster.routing.allocation.enable": "all"
  }
}
```

