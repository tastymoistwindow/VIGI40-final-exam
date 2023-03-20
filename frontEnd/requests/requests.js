const API_BASE_URL = "http://localhost:8080"

export const getPlayers = async () =>{
    const response = await fetch(`${API_BASE_URL}/player`)
    const players = await response.json()
    return players
}

export const getPlayerByID = async (id) => {
  const response = await fetch(`${API_BASE_URL}/player/${id}`);
  const player = await response.json();
  return player;
 };

export const savePlayer = async (player) => {
  await fetch(`${API_BASE_URL}/player`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(player),
  });

  alert("Player added successfully!");
};

 /* Labas, 
 testuodamas sutikau 2 bugus su redagavimu, kuriu nesupratau kaip pataisyti:
 1. Jei sukuriu nauja zaideja, bet kurdamas nenurodau datos, nuo kurios pradejo zaisti (playStartDate parametras), o veliau
 bandydamas redaguoti (per Postman siusdamas PATCH request ar svetaineje) gaunu 500 error. Narsykleje payload rodo kad data paduoda,
 bet neissaugo ir rodo pabraukta vieta patchPlayer metode, nurodysiu su komentaru zemiau. Gal gali paaiskinti, kodel taip veikia, kaip to isvengti? Aciu
 Vieta tavo atsakymuii 1. punkta:

 2. Nevisai bugas, bet redaguojant jau esamo zaidejo duomenis ir bandant esama data, nuo kurios narys pradejo zaisti (playStartDate parametras) pakeisti tuscia,
 ji nekinta, tai yra grazinama esanti data. Is pradzius galvojau, kad bugas, bet paskui paziurejau, ir taip greiciausiai del to, kad PlayerService klases editPlayerById funkcijoje
 yra sita validacija:
 if (player.getPlayStartDate() != null 
 del to ir nepriima null? Kita vertus, visiems kitiems laukams yra ta pati validacija ir ten galima sekmingai pakeisti esancias vertes i null ir sekmingai issaugo.
 Prasau, paaiskink, jei gali, aciu.

 */

export const patchPlayer = async (player, id) => { 
  await fetch(`${API_BASE_URL}/player/${id}`, { //gaunant 500 error rodo, kad kazkas negerai sitoje eiluteje pradedant nuo fetch su bugu 1. punkto aprase
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(player),
  });

  alert(`Update successful!`);
};

export const deletePlayerById = async (id) => {
  await fetch(`${API_BASE_URL}/player/${id}`, {
    method: "DELETE",
  });

  alert(`Player deleted successfully!`);
};