import 'dart:io';

int calcList(List<int> l1, List<int> l2) {
  l1.sort();
  l2.sort();
  int result = 0;

  for (int i = 0; i < l1.length; i++) {
    int diff = l1[i] - l2[i];
    if (diff < 0) {
      diff *= -1;
    }
    print(diff);
    result += diff;
  }
  print(result);
  return result;
}

int calcSimu(List<int> l1, List<int> l2) {
  int result = 0;
  for (int i = 0; i < l1.length; i++) {
    int multiplier = 0;
    for (int j = 0; j < l2.length; j++) {
      if (l1[i] == l2[j]) {
        multiplier++;
      }
    }
    result += (l1[i] * multiplier);
  }
  return result;
}

void main() async {
  List<int> listOne = [];
  List<int> listTwo = [];
  final filePath = '/home/florian/Dokumente/Development/AdventRiddles/data.txt';
  final file = File(filePath);

  if (await file.exists()) {
    final lines = await file.readAsLines();
    for (var line in lines) {
      final parts = line.split('   ');
      if (parts.length == 2) {
        listOne.add(int.parse(parts[0]));
        listTwo.add(int.parse(parts[1]));
      }
    }
  } else {
    print('Die Datei existiert nicht.');
  }
  print(calcSimu(listOne, listTwo));
}
