import java.io.File

fun main(){
    val filePath = "/home/florian/Dokumente/Development/AdventRiddles/data_day_2.txt"

    try{
        val lines: Array<String> = File(filePath).readLines()
        lines.forEach{ 
        }
    } catch(e: Exception){
        print("Fehler beim lesen der Datei")
    }

}
