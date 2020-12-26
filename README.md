"# CoroutineContext" 
   
      
Berdasarkan yang akan dilakukan oleh coroutine kita, ada beberapa Dispatchers :
1. Main = Coroutine akan dijalankan di Main Thread, berguna untuk UI Operation
2. I/O = Coroutine yang berguna untuk data operation seperti update database atau reading & writing files
3. Default = Digunakan untuk complex atau long running calculation untuk tidak block Main Thread dan UI kita
4. Unconfined = Coroutine tidak dibatasi pada Thread manapun
      
