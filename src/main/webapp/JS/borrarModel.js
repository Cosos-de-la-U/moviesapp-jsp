function borrarModal(url){
  Swal.fire({
    title: '¿Desea borrarlo?',
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: 'Borrar',
    denyButtonText: `No Borrar`,
  }).then((result) => {
    /* Read more about isConfirmed, isDenied below */
    if (result.isConfirmed) {
      Swal.fire('¡Fue eliminado!', '', 'success')
      window.location.replace(url);
    } else if (result.isDenied) {
      Swal.fire('No fue borrado', '', 'info')
    }
  })
}